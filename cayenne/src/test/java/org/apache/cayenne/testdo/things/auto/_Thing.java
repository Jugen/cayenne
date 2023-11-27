package org.apache.cayenne.testdo.things.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.ExpressionFactory;
import org.apache.cayenne.exp.property.EntityProperty;
import org.apache.cayenne.exp.property.ListProperty;
import org.apache.cayenne.exp.property.NumericProperty;
import org.apache.cayenne.exp.property.PropertyFactory;
import org.apache.cayenne.testdo.things.Ball;
import org.apache.cayenne.testdo.things.Box;

/**
 * Class _Thing was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Thing extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final NumericProperty<Long> ID_PK_PROPERTY = PropertyFactory.createNumeric(ExpressionFactory.dbPathExp("ID"), Long.class);
    public static final String ID_PK_COLUMN = "ID";

    public static final NumericProperty<Integer> VOLUME = PropertyFactory.createNumeric("volume", Integer.class);
    public static final NumericProperty<Integer> WEIGHT = PropertyFactory.createNumeric("weight", Integer.class);
    public static final EntityProperty<Ball> BALL = PropertyFactory.createEntity("ball", Ball.class);
    public static final ListProperty<Box> BOX = PropertyFactory.createList("box", Box.class);

    protected Integer volume;
    protected Integer weight;

    protected Object ball;
    protected Object box;

    public void setVolume(Integer volume) {
        beforePropertyWrite("volume", this.volume, volume);
        this.volume = volume;
    }

    public Integer getVolume() {
        beforePropertyRead("volume");
        return this.volume;
    }

    public void setWeight(Integer weight) {
        beforePropertyWrite("weight", this.weight, weight);
        this.weight = weight;
    }

    public Integer getWeight() {
        beforePropertyRead("weight");
        return this.weight;
    }

    public void setBall(Ball ball) {
        setToOneTarget("ball", ball, true);
    }

    public Ball getBall() {
        return (Ball)readProperty("ball");
    }

    @SuppressWarnings("unchecked")
    public List<Box> getBox() {
        return (List<Box>)readProperty("box");
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "volume":
                return this.volume;
            case "weight":
                return this.weight;
            case "ball":
                return this.ball;
            case "box":
                return this.box;
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
            case "volume":
                this.volume = (Integer)val;
                break;
            case "weight":
                this.weight = (Integer)val;
                break;
            case "ball":
                this.ball = val;
                break;
            case "box":
                this.box = val;
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
        out.writeObject(this.volume);
        out.writeObject(this.weight);
        out.writeObject(this.ball);
        out.writeObject(this.box);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.volume = (Integer)in.readObject();
        this.weight = (Integer)in.readObject();
        this.ball = in.readObject();
        this.box = in.readObject();
    }

}