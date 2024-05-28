package com.omersolutions.mvcinterfacehttp.user;

public record Address(
        String street,
        String suite,
        String city,
        String zipcode,
        Geo geo) {
}
