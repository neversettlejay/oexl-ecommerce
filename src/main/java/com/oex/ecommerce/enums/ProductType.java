package com.oex.ecommerce.enums;

public enum ProductType {
    APPARELANDACCESSORIES("Apparel and Accessories"),
    BOOKSANDMEDIA("Books and Media"),
    ELECTRONICSANDCOMPUTERS("Electronics and Computers"),
    OFFICEANDSCHOOLSUPPLIES("Office and School Supplies"),
    OTHERPRODUCTTYPE("Other Product type");

    private final String name;

    ProductType(String name) {
        this.name = name;
    }

    public String getName() {
        switch (this.name()) {
            case "APPARELANDACCESSORIES" -> {
                return APPARELANDACCESSORIES.toString();
            }
            case "BOOKSANDMEDIA" -> {
                return BOOKSANDMEDIA.toString();
            }
            case "ELECTRONICSANDCOMPUTERS" -> {
                return ELECTRONICSANDCOMPUTERS.toString();
            }
            case "OFFICEANDSCHOOLSUPPLIES" -> {
                return OFFICEANDSCHOOLSUPPLIES.toString();
            }
            case "OTHERPRODUCTTYPE" -> {
                return OTHERPRODUCTTYPE.toString();
            }
            default -> {
                return "Other Product type";
            }
        }
    }

    public String toString() {
        return this.name;
    }
}

