package com.github.mattmann.winterface.jsoup;

import com.github.mattmann.winterface.HTMLCollection;
import com.github.mattmann.winterface.HTMLElement;
import com.github.mattmann.winterface.HTMLFormElement;
import com.github.mattmann.winterface.HTMLOptionElement;
import com.github.mattmann.winterface.HTMLSelectElement;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import static org.apache.commons.lang.StringUtils.isNotEmpty;

public class JSoupSelectElement extends JSoupElement implements HTMLSelectElement {

	public JSoupSelectElement(Element element, JSoupDocument ownerDocument) {
		super(element, ownerDocument);
	}

	public String getType() {
		throw new UnsupportedOperationException();
	}

	public int getSelectedIndex() {
		HTMLCollection options = getOptions();
		for (int i = 0; i < options.getLength(); i++) {
			HTMLOptionElement option = (HTMLOptionElement)options.item(i);
			if (option.isSelected()) {
				return i;
			}
		}
		return 0;
	}

	protected HTMLOptionElement getSelectedOption() {
		HTMLCollection options = getOptions();
		if (options.getLength() == 0) {
			return null;
		}
		for (int i = 0; i < options.getLength(); i++) {
			HTMLOptionElement option = (HTMLOptionElement)options.item(i);
			if (option.isSelected()) {
				return option;
			}
		}
		return (HTMLOptionElement)options.item(0);
	}

	public void setSelectedIndex(int selectedIndex) {
		throw new UnsupportedOperationException();
	}

	public String getValue() {
		HTMLOptionElement option = getSelectedOption();
		if (option == null) {
			return null;
		}
		return option.getValue();
	}

	public void setValue(String value) {
		throw new UnsupportedOperationException();
	}

	public long getLength() {
		throw new UnsupportedOperationException();
	}

	public HTMLFormElement getForm() {
		throw new UnsupportedOperationException();
	}

	public HTMLCollection getOptions() {
		final Elements elements = node.select("option");
		return new HTMLCollection() {

			public int getLength() {
				return elements.size();
			}

			public Node item(int index) {
				return wrap(elements.get(index));
			}

			public Node namedItem(String name) {
				throw new UnsupportedOperationException();
			}
		};
	}

	public boolean isDisabled() {
		throw new UnsupportedOperationException();
	}

	public void setDisabled(boolean disabled) {
		throw new UnsupportedOperationException();
	}

	public boolean isMultiple() {
		throw new UnsupportedOperationException();
	}

	public void setMultiple(boolean multiple) {
		throw new UnsupportedOperationException();
	}

	public String getName() {
		final String name = getAttribute("name").toString();
		final String id = getAttribute("id").toString();
		if (isNotEmpty(name)) {
			return name;
		}
		if (isNotEmpty(id)) {
			return id;
		}
		return name;
	}

	public void setName(String name) {
		throw new UnsupportedOperationException();
	}

	public long getSize() {
		throw new UnsupportedOperationException();
	}

	public void setSize(long size) {
		throw new UnsupportedOperationException();
	}

	public long getTabIndex() {
		throw new UnsupportedOperationException();
	}

	public void setTabIndex(long tabIndex) {
		throw new UnsupportedOperationException();
	}

	public void add(HTMLElement element, HTMLElement before) throws DOMException {
		throw new UnsupportedOperationException();
	}

	public void remove(long index) {
		throw new UnsupportedOperationException();
	}

	public void blur() {
		throw new UnsupportedOperationException();
	}

	public void focus() {
		throw new UnsupportedOperationException();
	}

}
