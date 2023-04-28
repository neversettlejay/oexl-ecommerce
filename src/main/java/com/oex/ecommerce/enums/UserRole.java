package com.oex.ecommerce.enums;

public enum UserRole {
    CUSTOMER("Customer"),
    SELLER("Seller"),
    ADMIN("Admin");

    private final String name;

    UserRole(String name) {
        this.name = name;
    }

    public String getName() {
        switch (this.name()) {
            case "CUSTOMER" -> {
                return CUSTOMER.toString();
            }
            case "SELLER" -> {
                return SELLER.toString();
            }
            case "ADMIN" -> {
                return ADMIN.toString();
            }
            default -> {
                return "Unknown";
            }
        }
    }

    public String toString() {
        return this.name;
    }
}

