package RoutePlanner.core.controller.dao;

public class CafeVO {
    private String cafeno;
    private String cafefrom;
    private String cafename;
    private String cafekind;
    private String cafemenu;
    private String cafeaddr;
    private String cafegroup;

    public void setCafegroup(String cafegroup) {
        this.cafegroup = cafegroup;
    }

    public String getCafegroup() {
        return cafegroup;
    }

    public String getCafeno() {
        return cafeno;
    }

    public String getCafefrom() {
        return cafefrom;
    }

    public String getCafename() {
        return cafename;
    }

    public String getCafekind() {
        return cafekind;
    }

    public String getCafemenu() {
        return cafemenu;
    }

    public String getCafeaddr() {
        return cafeaddr;
    }

    public void setCafeno(String cafeno) {
        this.cafeno = cafeno;
    }

    public void setCafefrom(String cafefrom) {
        this.cafefrom = cafefrom;
    }

    public void setCafename(String cafename) {
        this.cafename = cafename;
    }

    public void setCafekind(String cafekind) {
        this.cafekind = cafekind;
    }

    public void setCafemenu(String cafemenu) {
        this.cafemenu = cafemenu;
    }

    public void setCafeaddr(String cafeaddr) {
        this.cafeaddr = cafeaddr;
    }
}
