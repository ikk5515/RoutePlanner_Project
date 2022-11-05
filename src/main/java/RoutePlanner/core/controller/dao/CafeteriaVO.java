package RoutePlanner.core.controller.dao;

public class CafeteriaVO {
    private String restno;
    private String restfrom;
    private String restname;
    private String restkind;
    private String restmenu;
    private String restaddr;
    private String restgroup;

    public void setRestgroup(String restgroup) {
        this.restgroup = restgroup;
    }

    public String getRestgroup() {
        return restgroup;
    }

    public String getRestno() {
        return restno;
    }

    public String getRestfrom() {
        return restfrom;
    }

    public String getRestname() {
        return restname;
    }

    public String getRestkind() {
        return restkind;
    }

    public String getRestmenu() {
        return restmenu;
    }

    public String getRestaddr() {
        return restaddr;
    }

    public void setRestno(String restno) {
        this.restno = restno;
    }

    public void setRestfrom(String resfrom) {
        this.restfrom = resfrom;
    }

    public void setRestname(String restname) {
        this.restname = restname;
    }

    public void setRestkind(String restkind) {
        this.restkind = restkind;
    }

    public void setRestmenu(String restmenu) {
        this.restmenu = restmenu;
    }

    public void setRestaddr(String restaddr) {
        this.restaddr = restaddr;
    }
}
