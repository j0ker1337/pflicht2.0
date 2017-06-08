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
    private boolean state5;
    private boolean state6;
    private boolean state7;

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
        state5 = false;
        state6 = false;
        state7 = false;

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
        this.state4 = st;
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

    public boolean getState5() {
        return state5;
    }

    public void setState5(boolean state5) {
        this.state5 = state5;
    }

    public boolean getState6() {
        return state6;
    }

    public void setState6(boolean state6) {
        this.state6 = state6;
    }

    public boolean getState7() {
        return state7;
    }

    public void setState7(boolean state7) {
        this.state7 = state7;
    }

    public void choosestate0() {
        setState0(true);
        setState1(false);
        setState2(false);
        setState3(false);
        setState4(false);
        setState5(false);
        setState6(false);
        setState7(false);

    }

    public void choosestate1() {
        setState0(false);
        setState1(true);
        setState2(false);
        setState3(false);
        setState4(false);
        setState5(false);
        setState6(false);
        setState7(false);
    }

    public void choosestate2() {
        setState0(false);
        setState1(false);
        setState2(true);
        setState3(false);
        setState4(false);
        setState5(false);
        setState6(false);
        setState7(false);
    }

    public void choosestate3() {
        setState0(false);
        setState1(false);
        setState2(false);
        setState3(true);
        setState4(false);
        setState5(false);
        setState6(false);
        setState7(false);
    }

    public void choosestate4() {
        setState0(false);
        setState1(false);
        setState2(false);
        setState3(false);
        setState4(true);
        setState5(false);
        setState6(false);
        setState7(false);
    }

    public void choosestate5() {
        setState0(false);
        setState1(false);
        setState2(false);
        setState3(false);
        setState4(false);
        setState5(true);
        setState6(false);
        setState7(false);
    }

    public void choosestate6() {
        setState0(false);
        setState1(false);
        setState2(false);
        setState3(false);
        setState4(false);
        setState5(false);
        setState6(true);
        setState7(false);
    }

    public void choosestate7() {
        setState0(false);
        setState1(false);
        setState2(false);
        setState3(false);
        setState4(false);
        setState5(false);
        setState6(false);
        setState7(true);
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
