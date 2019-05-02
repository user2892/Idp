package com.bectran.b2b.supplier.beans;

/**
 * @author LOUIS IFEGUNI
 */
public class UICustomizationBean {
    private boolean basic;
    private boolean loggedIn;
    private boolean headerIn;

    //
    public boolean isBasic() {
        return basic;
    }

    public void setBasic(boolean basic) {
        this.basic = basic;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public boolean isHeaderIn() {
        return headerIn;
    }

    public void setHeaderIn(boolean headerIn) {
        this.headerIn = headerIn;
    }
}
