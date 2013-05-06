package com.github.mattmann.winterface.jsoup;

import org.jsoup.nodes.TextNode;
import com.github.mattmann.winterface.DOMException;
import com.github.mattmann.winterface.Text;
import static org.apache.commons.lang.Validate.notNull;

public class JSoupText extends JSoupNode<TextNode> implements Text {

	private final JSoupDocument ownerDocument;

	public JSoupText(TextNode node, JSoupDocument ownerDocument) {
		super(node);
		notNull(this.ownerDocument = ownerDocument);
	}

	public JSoupDocument getOwnerDocument() {
		return ownerDocument;
	}

	public CharSequence getData() {
		return node.text();
	}

	public CharSequence substringData(int offset, int count) throws DOMException {
		return node.text().subSequence(offset, offset + count);
	}

	public long getLength() {
		throw new UnsupportedOperationException();
	}

	public void appendData(CharSequence arg) throws DOMException {
		throw new UnsupportedOperationException();
	}

	public void deleteData(int offset, int count) throws DOMException {
		throw new UnsupportedOperationException();
	}

	public void insertData(int offset, CharSequence arg) throws DOMException {
		throw new UnsupportedOperationException();
	}

	public void replaceData(int offset, int count, CharSequence arg) throws DOMException {
		throw new UnsupportedOperationException();
	}

	public void setData(CharSequence data) {
		throw new UnsupportedOperationException();
	}

	public Text splitText(int offset) throws DOMException {
		throw new UnsupportedOperationException();
	}

	public String toString() {
		return node.text();
	}
}
