package com.github.snoblind.winterface.util;

import com.github.snoblind.winterface.ExtendedHTMLCollection;
import java.util.AbstractList;
import java.util.List;
import org.w3c.dom.Node;
import static org.apache.commons.lang.Validate.notNull;

public class HTMLCollectionAdapter extends AbstractList<Node> implements ExtendedHTMLCollection {
	
	private final List<Node> nodes;

	public HTMLCollectionAdapter(List<Node> nodes) {
		notNull(this.nodes = nodes);
	}

	public int getLength() {
		return nodes.size();
	}

	public int size() {
		return nodes.size();
	}

	public Node item(int index) {
		try {
			return nodes.get(index);
		}
		catch (IndexOutOfBoundsException x) {
			return null;
		}
	}

	public Node get(int index) {
		return nodes.get(index);
	}

	public Node namedItem(String name) {
		return NodeListUtils.namedItem(name, nodes);
	}

	public String toString() {
		return NodeListUtils.toString(nodes);
	}
}