/*
 * Copyright 2021 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.test.tree;

import java.util.List;

public interface MyNode
{
	List<MyNode> getChildren();
}
