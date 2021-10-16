/*
 * Copyright 2021 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import de.cgarbs.test.formatter2.html.HtmlFormatter;
import de.cgarbs.test.formatter2.markdown.MarkdownFormatter;
import de.cgarbs.test.tree.MyNode;

public class Formatter2Test
{
	@Test
	public void checkHtmlFormatter()
	{
		// given
		MyNode input = TestData.TEST_DOCUMENT;

		// when
		String output = new HtmlFormatter().toHtml(input);

		// then
		assertThat(output).isEqualTo(TestData.EXPECTED_HTML);
	}

	@Test
	public void checkMarkdownFormatter()
	{
		// given
		MyNode input = TestData.TEST_DOCUMENT;

		// when
		String output = new MarkdownFormatter().toMarkdown(input);

		// then
		System.out.println(output);
		assertThat(output).isEqualTo(TestData.EXPECTED_MARKDOWN);
	}
}
