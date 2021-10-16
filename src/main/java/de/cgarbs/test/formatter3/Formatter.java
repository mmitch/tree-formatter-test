/*
 * Copyright 2021 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.test.formatter3;

import de.cgarbs.test.tree.MyNode;

public interface Formatter<T extends MyNode>
{
	Class<T> responsibleFor();
}
