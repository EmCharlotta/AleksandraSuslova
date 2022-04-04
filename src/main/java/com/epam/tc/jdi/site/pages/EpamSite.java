package com.epam.tc.jdi.site.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class EpamSite {

    @Url("/index.html")
    public static IndexPage indexPage;
    public static MetalsPage metalsPage;
}
