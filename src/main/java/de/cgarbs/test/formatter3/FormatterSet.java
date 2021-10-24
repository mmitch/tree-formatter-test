/*
 * Copyright 2021 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.test.formatter3;

import java.util.HashMap;
import java.util.Map;

import de.cgarbs.test.tree.MyNode;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;
import lombok.SneakyThrows;

public class FormatterSet<T extends Formatter>
{

	private final Class<T> formatterBase;
	private final Map<Class<? extends MyNode>, T> formatters = new HashMap<>();

	public T getFor(MyNode node)
	{
		var formatter = formatters.get(node.getClass());
		if (formatter == null)
		{
			throw new RuntimeException("no formatter found for " + node.getClass() + " under " + formatterBase);
		}
		return formatter;
	}

	public <U extends MyNode> void apply(U node, Class<U> nodeType)
	{
		T formatter = getFor(node);

	}

	@SuppressWarnings("unchecked")
	public FormatterSet(Class<T> formatterBase)
	{
		this.formatterBase = formatterBase;

		try (ScanResult scanResult = new ClassGraph().acceptPackagesNonRecursive(formatterBase.getPackageName()).scan())
		{
			scanResult.getClassesImplementing(formatterBase).forEach(formatterClassInfo -> {
				registerFormatter((Class<T>) formatterClassInfo.loadClass());
			});
		}
	}

	@SneakyThrows
	@SuppressWarnings("unchecked")
	private void registerFormatter(Class<T> formatterClass)
	{
		T formatter = formatterClass.getDeclaredConstructor().newInstance();
		formatters.put(formatter.responsibleFor(), formatter);
	}

}
