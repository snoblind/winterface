package com.github.snoblind.winterface.nashorn;

import com.github.snoblind.winterface.Event;
import com.github.snoblind.winterface.EventException;
import com.github.snoblind.winterface.EventListener;
import com.github.snoblind.winterface.ExtendedHTMLCollection;
import com.github.snoblind.winterface.ExtendedHTMLDocument;
import com.github.snoblind.winterface.Window;
import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.EntityReference;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;
import org.w3c.dom.html.HTMLCollection;
import org.w3c.dom.html.HTMLElement;

public class NashornDocument extends NashornNode implements ExtendedHTMLDocument {

	private String xmlEncoding;
	private boolean xmlStandalone;
	private String xmlVersion;

	public Document getOwnerDocument() {
		return this;
	}

	public String getNodeValue() {
		return null;
	}

	public void setNodeValue(String nodeValue) {
	}

	public NamedNodeMap getAttributes() {
		return null;
	}

	public String getNamespaceURI() {
		return null;
	}

	public String getLocalName() {
		return null;
	}

	public short getNodeType() {
		return DOCUMENT_NODE;
	}

	public String getNodeName() {
		return "#document";
	}

	public String getXmlEncoding() {
		return xmlEncoding;
	}

	public void setXmlEncoding(String xmlEncoding) {
		this.xmlEncoding = xmlEncoding;
	}

	public boolean getXmlStandalone() {
		return xmlStandalone;
	}

	public void setXmlStandalone(boolean xmlStandalone) {
		this.xmlStandalone = xmlStandalone;
	}

	public String getXmlVersion() {
		return xmlVersion;
	}

	public void setXmlVersion(String xmlVersion) {
		this.xmlVersion = xmlVersion;
	}

	public String getTitle() {
		throw new UnsupportedOperationException();
	}

	public void setTitle(String title) {
		throw new UnsupportedOperationException();
	}

	public String getReferrer() {
		throw new UnsupportedOperationException();
	}

	public String getDomain() {
		throw new UnsupportedOperationException();
	}

	public String getURL() {
		throw new UnsupportedOperationException();
	}

	public HTMLElement getBody() {
		throw new UnsupportedOperationException();
	}

	public void setBody(HTMLElement body) {
		throw new UnsupportedOperationException();
	}

	public HTMLCollection getImages() {
		throw new UnsupportedOperationException();
	}

	public HTMLCollection getApplets() {
		throw new UnsupportedOperationException();
	}

	public HTMLCollection getLinks() {
		throw new UnsupportedOperationException();
	}

	public HTMLCollection getForms() {
		throw new UnsupportedOperationException();
	}

	public HTMLCollection getAnchors() {
		throw new UnsupportedOperationException();
	}

	public String getCookie() {
		throw new UnsupportedOperationException();
	}

	public void setCookie(String cookie) {
		throw new UnsupportedOperationException();
	}

	public void open() {
		throw new UnsupportedOperationException();
	}

	public void close() {
		throw new UnsupportedOperationException();
	}

	public void write(String text) {
		throw new UnsupportedOperationException();
	}

	public void writeln(String text) {
		throw new UnsupportedOperationException();
	}

	public DocumentType getDoctype() {
		throw new UnsupportedOperationException();
	}

	public DOMImplementation getImplementation() {
		throw new UnsupportedOperationException();
	}

	public Element getDocumentElement() {
		throw new UnsupportedOperationException();
	}

	public Element createElement(String tagName) throws DOMException {
		switch (tagName) {
		case "a":
			return new NashornAnchorElement(this);
		case "body":
			return new NashornBodyElement(this);
		case "br":
			return new NashornBRElement(this);
		case "div":
			return new NashornDivElement(this);
		case "dl":
			return new NashornDListElement(this);
		case "fieldset":
			return new NashornFieldSetElement(this);
		case "font":
			return new NashornFontElement(this);
		case "form":
			return new NashornFormElement(this);
		case "h1":
		case "h2":
		case "h3":
		case "h4":
		case "h5":
		case "h6":
			return new NashornHeadingElement(tagName, this);
		case "head":
			return new NashornHeadElement(this);
		case "html":
			return new NashornHtmlElement(this);
		case "iframe":
			return new NashornIFrameElement(this);
		case "img":
			return new NashornImageElement(this);
		case "input":
			return new NashornInputElement(this);
		case "label":
			return new NashornLabelElement(this);
		case "li":
			return new NashornLIElement(this);
		case "link":
			return new NashornLinkElement(this);
		case "meta":
			return new NashornMetaElement(this);
		case "ol":
			return new NashornOListElement(this);
		case "option":
			return new NashornOptionElement(this);
		case "p":
			return new NashornParagraphElement(this);
		case "script":
			return new NashornScriptElement(this);
		case "select":
			return new NashornSelectElement(this);
		case "style":
			return new NashornStyleElement(this);
		case "table":
			return new NashornTableElement(this);
		case "textarea":
			return new NashornTextAreaElement(this);
		case "title":
			return new NashornTitleElement(this);
		case "td":
			return new NashornTableCellElement(this);
		case "tr":
			return new NashornTableRowElement(this);
		case "ul":
			return new NashornUListElement(this);
		case "article":
		case "b":
		case "center":
		case "dd":
		case "dt":
		case "em":
		case "footer":
		case "header":
		case "i":
		case "icon":
		case "nav":
		case "nobr":
		case "noscript":
		case "section":
		case "span":
		case "strong":
		case "tbody":
		case "time":
		case "u":
			return new NashornElement(tagName, this);
		default:
			throw new IllegalArgumentException(tagName);
		}
	}

	public DocumentFragment createDocumentFragment() {
		return new NashornDocumentFragment(this);
	}

	public Text createTextNode(String data) {
		return new NashornText(data, this);
	}

	public Comment createComment(String data) {
		return new NashornComment(data, this);
	}

	public CDATASection createCDATASection(String data) throws DOMException {
		return new NashornCDATASection(data, this);
	}

	public ProcessingInstruction createProcessingInstruction(String target, String data) throws DOMException {
		throw new UnsupportedOperationException();
	}

	public Attr createAttribute(String name) throws DOMException {
		return new NashornAttribute(name, this);
	}

	public EntityReference createEntityReference(String name) throws DOMException {
		throw new UnsupportedOperationException();
	}

	public NodeList getElementsByTagName(String tagname) {
		throw new UnsupportedOperationException();
	}

	public Node importNode(Node importedNode, boolean deep) throws DOMException {
		throw new UnsupportedOperationException();
	}

	public Element createElementNS(String namespaceURI, String qualifiedName) throws DOMException {
		throw new UnsupportedOperationException();
	}

	public Attr createAttributeNS(String namespaceURI, String qualifiedName) throws DOMException {
		throw new UnsupportedOperationException();
	}

	public NodeList getElementsByTagNameNS(String namespaceURI, String localName) {
		throw new UnsupportedOperationException();
	}

	public Element getElementById(String elementId) {
		throw new UnsupportedOperationException();
	}

	public String getInputEncoding() {
		throw new UnsupportedOperationException();
	}

	public boolean getStrictErrorChecking() {
		throw new UnsupportedOperationException();
	}

	public void setStrictErrorChecking(boolean strictErrorChecking) {
		throw new UnsupportedOperationException();
	}

	public String getDocumentURI() {
		throw new UnsupportedOperationException();
	}

	public void setDocumentURI(String documentURI) {
		throw new UnsupportedOperationException();
	}

	public Node adoptNode(Node source) throws DOMException {
		throw new UnsupportedOperationException();
	}

	public DOMConfiguration getDomConfig() {
		throw new UnsupportedOperationException();
	}

	public void normalizeDocument() {
		throw new UnsupportedOperationException();
	}

	public Node renameNode(Node n, String namespaceURI, String qualifiedName) throws DOMException {
		throw new UnsupportedOperationException();
	}

	public void addEventListener(String type, EventListener listener, boolean useCapture) {
		throw new UnsupportedOperationException();
	}

	public void removeEventListener(String type, EventListener listener, boolean useCapture) {
		throw new UnsupportedOperationException();
	}

	public boolean dispatchEvent(Event event) throws EventException {
		throw new UnsupportedOperationException();
	}

	public Element querySelector(String selectors) {
		throw new UnsupportedOperationException();
	}

	public ExtendedHTMLCollection querySelectorAll(String selectors) {
		throw new UnsupportedOperationException();
	}

	public ExtendedHTMLCollection getElementsByName(String elementName) {
		throw new UnsupportedOperationException();
	}

	public Window getDefaultView() {
		throw new UnsupportedOperationException();
	}
}