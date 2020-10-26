package util.Parser;

public enum HTMLTags {

    PARAGRAPH_TAG("p"), LINK_TAG("a"), SPAN_TAG("span"), CODE_TAG("code"), ABBR_TAG("abbr"), ACRONYM_TAG("acronym"),
    ADDRESS_TAG("address"), BOLD_FONT_TAG("b"), BDO_TAG("bdo"), BIG_TAG("big"), BLINK_TEXT("blink"), BLOCKQUOTE_TAG("blockquote"),
    CITE_TAG("cite"), DFN_TAG("dfn"), EM_TAG("em"), FONT_TAG("font"), H1_TAG("h1"), H2_TAG("h2"), H3_TAG("h3"), H4_TAG("h4"),
    H5_TAG("h5"), H6_TAG("h6"), ITALIC_TAG("i"), DEL_TAG("del"), INS_TAG("ins"), KBD_TAG("kbd"), MARK_TAG("mark"), NOBR_TAG("nobr"),
    PLAINTEXT_TAG("plaintext"), QUOTE_TAG("q"), RUBY_TAG("ruby"), RT_TAG("rt"), STRIKETHROUGH_TAG("s"), SAMP_TAG("samp"),
    SMALL_TAG("small"), SUBSCRIPT_TAG("sub"), SUPERSCRIPT_TAG("sup"), TELETYPE_TAG("tt"), UNDERLINE_TAG("u"), VAR_TAG("var"),
    WBR_TAG("wbr"), PRE_TAG("pre"), XMP_TAG("xmp"), BUTTON_TAG("button"), TD_TAG("td"), TH_TAG("th"), INPUT_TAG("input"),
    LABEL_TAG("label"), OPTION_TAG("option"), DIV_TAG("div");

    private String name;

    HTMLTags(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
