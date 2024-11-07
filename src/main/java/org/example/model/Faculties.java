/*
 * 1
 */

package org.example.model;

public enum Faculties {
    LAW("Faculty of Law"), MEDICINE("Faculty of Medicine"), HUMANITIES("Faculty of Humanities"), HEALTH_SCIENCES("Faculty of Health Sciences"), DENTISTRY("Faculty of Dentistry"), ECONOMICS_AND_BUSINESS("Faculty of Economics and Business"), PHARMACY("Faculty of Pharmacy"), INFORMATICS("Faculty of Informatics"), AGRICULTURE("Faculty of Agricultural and Food Sciences and Environmental Management"), ENGINEERING("Faculty of Engineering"), SCIENCE_AND_TECHNOLOGY("Faculty of Science and Technology"), MUSIC("Faculty of Music"), EDUCATION_FOR_CHILDREN("Faculty of Education for Children and Special Educational Needs"), NONE("None");


    private final String toString;

    private Faculties(String toString) {
        this.toString = toString;
    }

    public String toString() {
        return toString;
    }
}
