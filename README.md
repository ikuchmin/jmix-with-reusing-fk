## Demo project showing behaviour of JMIX platform when reference doesn't exist

There is three custom entities T004, Ska1 and CTable. CTable contains two references ManyToOne
which using same column ktopl. The main question how this will work in EclipseLink (aka JPA)

**Tables in DB doesn't have foreign keys**

It is init condition

**Only one ref can use column name in updatable manner**

To avoid this problem ktopl ref declaration in saknr (CTable) field is declared as read-only

```java
    @JoinColumns({
            @JoinColumn(name = "SAKNR", referencedColumnName = "SAKNR"),
            @JoinColumn(name = "KTOPL", referencedColumnName = "KTOPL",
                    insertable = false, updatable = false)
    })
    @ManyToOne(fetch = FetchType.LAZY)
    private Ska1 saknr;
```

**Empty object in saknr if combination of (SAKNR, KTOPL) doesn't exist in Ska1**

This behaviour is logically correct, but it is making getting value of SAKNR not easy to
show in screen, for example in Editor screen. It is possible when someone delete object in
Ska1 when object already using in CTable (do not have foreign keys in DB). Or inappropriate
value can be passing in CTable by migration

**What if we create object of Ska1 by load with partial key**

To do it we need first in (org.eclipse.persistence.mappings.OneToOneMapping.valueFromRowInternalWithJoin) avoid:
```
        AbstractRecord targetRow = trimRowForJoin(row, joinManager, executionSession);
```
because `trimRowForJoin` removes fields which were getting not from SKA1 table (saknr value is placed in CTable)

next one in (org.eclipse.persistence.internal.descriptors.ObjectBuilder.extractPrimaryKeyFromRow) rewrite the
way getting key fields (because in this way it returns `null`):
```java
        Object value = databaseRow.get(field);
```

the last one do not forget to set `this.mayHaveNullInPrimaryKey` in true
(org.eclipse.persistence.internal.descriptors.ObjectBuilder.mayHaveNullInPrimaryKey)

### Test

1. Create Ska1 with (KTOPL=10, SAKNR=10)
2. Create T004 with (KTOPL=1)
3. Create CTable with created early Ska1 and T004
4. Refresh Browse for CTable. saknr field must be empty