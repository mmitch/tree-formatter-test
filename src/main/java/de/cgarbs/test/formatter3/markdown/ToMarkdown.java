/*
 * Copyright 2021 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.test.formatter3.markdown;

import de.cgarbs.test.formatter3.Formatter;
import de.cgarbs.test.tree.MyNode;

public interface ToMarkdown<T extends MyNode> extends Formatter<T>
{
	void appendMarkdown(StringBuilder markdown, T node);
}
