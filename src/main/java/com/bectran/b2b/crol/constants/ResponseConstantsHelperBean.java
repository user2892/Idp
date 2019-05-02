package com.bectran.b2b.crol.constants;

import java.util.Comparator;

/**
 * @author Louis Ifeguni Aug 17, 2006: 3:12:43 PM
 */
public class ResponseConstantsHelperBean {
    public static final Comparator ASCENDING_ORDER = new Comparator() {
        public int compare(Object o1, Object o2) {
            ResponseConstantsHelperBean r1 = (ResponseConstantsHelperBean) o1;
            ResponseConstantsHelperBean r2 = (ResponseConstantsHelperBean) o2;
            return Integer.valueOf(r1.getOrder())
                    .compareTo(Integer.valueOf(r2.getOrder()));
        }
    };

    public ResponseConstantsHelperBean(int _order, String _key, String _value) {
        //
        this.order = _order;
        this.key = _key;
        this.value = _value;
    }
    private String key;
    private String value;
    private int order;

    /**
     * @return Returns the key.
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key
     *            The key to set.
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @return Returns the order.
     */
    public int getOrder() {
        return order;
    }

    /**
     * @param order
     *            The order to set.
     */
    public void setOrder(int order) {
        this.order = order;
    }

    /**
     * @return Returns the value.
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value
     *            The value to set.
     */
    public void setValue(String value) {
        this.value = value;
    }
}
