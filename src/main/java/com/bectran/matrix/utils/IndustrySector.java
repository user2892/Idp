package com.bectran.matrix.utils;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * @author Louis Ifeguni Aug 1, 2006: 4:23:20 PM
 */
public class IndustrySector {
    public static final Comparator ASCENDING_SECTOR_ORDER = new Comparator() {
        public int compare(Object o1, Object o2) {
            IndustrySector r1 = (IndustrySector) o1;
            IndustrySector r2 = (IndustrySector) o2;
            return r1.getSectorName().compareTo(r2.getSectorName());
        }
    };
    public static final Comparator ASCENDING_INDUSTRY_ORDER = new Comparator() {
        public int compare(Object o1, Object o2) {
            IndustrySector r1 = (IndustrySector) o1;
            IndustrySector r2 = (IndustrySector) o2;
            return r1.getIndustryName().compareTo(r2.getIndustryName());
        }
    };
    //
    public static final String NONE = "N"; // initialization value for sectors
    //
    private String sectorId;
    private String sectorName;
    private String industryId;
    private String industryName;
    //
    /**
     * @return Returns the industryId.
     */
    public String getIndustryId() {
        return industryId;
    }

    /**
     * @param industryId
     *            The industryId to set.
     */
    public void setIndustryId(String industryId) {
        this.industryId = industryId;
    }

    /**
     * @return Returns the industryName.
     */
    public String getIndustryName() {
        return industryName;
    }

    /**
     * @param industryName
     *            The industryName to set.
     */
    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    /**
     * @return Returns the sectorId.
     */
    public String getSectorId() {
        return sectorId;
    }

    /**
     * @param sectorId
     *            The sectorId to set.
     */
    public void setSectorId(String sectorId) {
        this.sectorId = sectorId;
    }

    /**
     * @return Returns the sectorName.
     */
    public String getSectorName() {
        return sectorName;
    }

    /**
     * @param sectorName
     *            The sectorName to set.
     */
    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

   /* *//**
     * @param industriesForSector
     *            The industriesForSector to set.
     *//*
    public void setIndustriesForSector(List industriesForSector) {
        this.industriesForSector = industriesForSector;
    }*/

    /**
     * @return Returns the sectorIndusry.
     */
    public static List getSectorIndusry() {
        List list = IndustrySectorHelper.getSectors();
        return list;
    }

    /**
     * @return Returns the sectors.
     */
    public static String getSectorName(String sectorId) {
        List xmlDoclist = IndustrySectorHelper.getSectors();
        for (Iterator i = xmlDoclist.iterator(); i.hasNext();) {
            IndustrySector sector = (IndustrySector) i.next();
            if (sector.getSectorId().trim().equals(sectorId.trim())) {
                return sector.getSectorName();
            }
        }
        return "";
    }

    /**
     * @return Returns the sectors.
     */
    public static String getIndustryName(String industryId) {
        List xmlDoclist = IndustrySectorHelper.getSectorIndustryData();
        for (Iterator i = xmlDoclist.iterator(); i.hasNext();) {
            //
            IndustrySector sector = (IndustrySector) i.next();
            if (sector.getIndustryId().trim().equals(industryId.trim())) {
                return sector.getIndustryName();
            }
        }
        return "";
    }

}
