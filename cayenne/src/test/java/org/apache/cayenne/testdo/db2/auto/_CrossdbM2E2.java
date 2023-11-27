package org.apache.cayenne.testdo.db2.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.property.EntityProperty;
import org.apache.cayenne.exp.property.PropertyFactory;
import org.apache.cayenne.exp.property.StringProperty;
import org.apache.cayenne.testdo.db1.CrossdbM1E1;
import org.apache.cayenne.testdo.db2.CrossdbM2E1;

/**
 * Class _CrossdbM2E2 was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _CrossdbM2E2 extends BaseDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String ID_PK_COLUMN = "ID";

    public static final StringProperty<String> NAME = PropertyFactory.createString("name", String.class);
    public static final EntityProperty<CrossdbM1E1> TO_M1E1 = PropertyFactory.createEntity("toM1E1", CrossdbM1E1.class);
    public static final EntityProperty<CrossdbM2E1> TO_M2E1 = PropertyFactory.createEntity("toM2E1", CrossdbM2E1.class);

    protected String name;

    protected Object toM1E1;
    protected Object toM2E1;

    public void setName(String name) {
        beforePropertyWrite("name", this.name, name);
        this.name = name;
    }

    public String getName() {
        beforePropertyRead("name");
        return this.name;
    }

    public void setToM1E1(CrossdbM1E1 toM1E1) {
        setToOneTarget("toM1E1", toM1E1, true);
    }

    public CrossdbM1E1 getToM1E1() {
        return (CrossdbM1E1)readProperty("toM1E1");
    }

    public void setToM2E1(CrossdbM2E1 toM2E1) {
        setToOneTarget("toM2E1", toM2E1, true);
    }

    public CrossdbM2E1 getToM2E1() {
        return (CrossdbM2E1)readProperty("toM2E1");
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "name":
                return this.name;
            case "toM1E1":
                return this.toM1E1;
            case "toM2E1":
                return this.toM2E1;
            default:
                return super.readPropertyDirectly(propName);
        }
    }

    @Override
    public void writePropertyDirectly(String propName, Object val) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch (propName) {
            case "name":
                this.name = (String)val;
                break;
            case "toM1E1":
                this.toM1E1 = val;
                break;
            case "toM2E1":
                this.toM2E1 = val;
                break;
            default:
                super.writePropertyDirectly(propName, val);
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        writeSerialized(out);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        readSerialized(in);
    }

    @Override
    protected void writeState(ObjectOutputStream out) throws IOException {
        super.writeState(out);
        out.writeObject(this.name);
        out.writeObject(this.toM1E1);
        out.writeObject(this.toM2E1);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.name = (String)in.readObject();
        this.toM1E1 = in.readObject();
        this.toM2E1 = in.readObject();
    }

}