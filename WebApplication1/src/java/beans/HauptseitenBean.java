package beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "HauptseitenBean")
@SessionScoped
public class HauptseitenBean implements Serializable {

    private boolean state0;
    private boolean state1;
    private boolean state2;
    private boolean state3;
    private boolean state4;
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public HauptseitenBean() {
        state0 = true;
        state1 = false;
        state2 = false;
        state3 = false;
        state4 = false;

    }

    public String irgendeineMethode() {
        if (state0) {
            System.out.println("beans.HauptseitenBean.irgendeineMethode() true");
            return "poop";
        } else {
            System.out.println("beans.HauptseitenBean.irgendeineMethode() false");
            return "paap";
        }

    }

    public void setState0(boolean st) {
        this.state0 = st;
    }

    public void setState4(boolean st) {
        this.state0 = st;
    }

    public boolean getState0() {
        return this.state0;
    }

    public void setState1(boolean st) {
        this.state1 = st;
    }

    public boolean getState1() {
        return this.state1;
    }

    public void setState2(boolean st) {
        this.state2 = st;
    }

    public boolean getState2() {
        return this.state2;
    }

    public void setState3(boolean st) {
        this.state3 = st;
    }

    public boolean getState3() {
        return this.state3;
    }

    public boolean getState4() {
        return state4;
    }

    public void choosestate0() {
        setState0(true);
        setState1(false);
        setState2(false);
        setState3(false);
        setState4(false);
    }

    public void choosestate1() {
        setState0(false);
        setState1(true);
        setState2(false);
        setState3(false);
        setState4(false);
    }

    public void choosestate2() {
        setState0(false);
        setState1(false);
        setState2(true);
        setState3(false);
        setState4(false);
    }

    public void choosestate3() {
        setState0(false);
        setState1(false);
        setState2(false);
        setState3(true);
        setState4(false);
    }

    public void choosestate4() {
        setState0(false);
        setState1(false);
        setState2(false);
        setState3(false);
        setState4(true);
    }
    /*public void setstate(int st){
        switch (st) {
            case 0:
                this.state0=true;
                this.state1=false;
                this.state2=false;
                this.state3=false;
                break;
            case 1:
                this.state0=false;
                this.state1=true;
                this.state2=false;
                this.state3=false;
                break;
            case 2:
                this.state0=false;
                this.state1=false;
                this.state2=true;
                this.state3=false;
                break;
            case 3:
                this.state0=false;
                this.state1=false;
                this.state2=false;
                this.state3=true;
                break;
            default:
                break;
        }
    }*/
}