package org.example;

public enum Faculties {
    LAW("Faculty of Law"), MEDICINE("Faculty of Medicine"), HUMANITIES("Faculty of Humanities"), HEALTH_SCIENCES("Faculty of Health Sciences"), DENTISTRY("Faculty of Dentistry"), ECONOMICS_AND_BUSINESS("Faculty of Economics and Business"), PHARMACY("Faculty of Pharmacy"), INFORMATICS("Faculty of Informatics"), AGRICULTURE("Faculty of Agricultural and Food Sciences and Environmental Management"), ENGINEERING("Faculty of Engineering"), SCIENCE_AND_TECHNOLOGY("Faculty of Science and Technology"), MUSIC("Faculty of Music"), EDUCATION_FOR_CHILDREN("Faculty of Education for Children and Special Educational Needs"), NONE("None");


    private final String displayName;

    // Konstruktor a displayName tárolására
    Faculties(String displayName) {
        this.displayName = displayName;
    }

    // Visszaadja az emberi olvasható formát (pl. "Faculty of Law")
    @Override
    public String toString() {
        return displayName;
    }

    // Visszaadja az enum nevét (pl. LAW, MEDICINE, stb.)
    public String getEnumName() {
        return this.name();
    }

    // Statikus metódus, amely szöveges érték alapján visszaadja az enum-ot
    public static Faculties fromString(String displayName) {
        for (Faculties faculty : Faculties.values()) {
            if (faculty.displayName.equalsIgnoreCase(displayName)) {
                return faculty;
            }
        }
        return Faculties.NONE; // Ha nem található egyezés, visszatér a NONE értékkel
    }
}
