/*
 * Copyright 2021 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.test;

import static de.cgarbs.test.tree.MyLink.link;
import static de.cgarbs.test.tree.MyList.list;
import static de.cgarbs.test.tree.MyText.text;

import de.cgarbs.test.tree.MyNode;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TestData
{
	public final static MyNode TEST_DOCUMENT = //
			list( //
					text("some text"), //
					link("https://www.cgarbs.de", text("HOMEPAGE")), //
					text("some more text") //
			);

	public final static String EXPECTED_HTML = "" //
			+ "<ul>\n" //
			+ " <li>some text</li>\n" //
			+ " <li><a href=\"https://www.cgarbs.de\">HOMEPAGE</a></li>\n" //
			+ " <li>some more text</li>\n" //
			+ "</ul>";

	public final static String EXPECTED_MARKDOWN = "" //
			+ " *  some text\n" //
			+ " *  [HOMEPAGE](https://www.cgarbs.de)\n" //
			+ " *  some more text\n";

}
