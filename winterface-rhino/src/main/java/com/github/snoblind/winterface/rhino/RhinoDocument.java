package com.github.snoblind.winterface.rhino;

import com.github.snoblind.winterface.Event;
import com.github.snoblind.winterface.EventException;
import com.github.snoblind.winterface.EventListener;
import com.github.snoblind.winterface.ExtendedHTMLDocument;
import com.github.snoblind.winterface.ExtendedHTMLElement;
import com.github.snoblind.winterface.Window;
import com.github.snoblind.winterface.event.EventDispatcher;
import com.github.snoblind.winterface.spi.CachingNodeAdapterFactory;
import com.github.snoblind.winterface.spi.HTMLParser;
import com.github.snoblind.winterface.spi.NodeAdapterFactory;
import com.github.snoblind.winterface.spi.QuerySelector;
import com.github.snoblind.winterface.util.NodeListUtils;
import java.util.Map;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;
import org.springframework.beans.factory.annotation.Required;
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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;
import org.w3c.dom.html.HTMLCollection;
import org.w3c.dom.html.HTMLElement;
import org.w3c.dom.html.HTMLTitleElement;
import static com.github.snoblind.winterface.required.RequiredProperties.assertRequiredProperties;

public class RhinoDocument extends RhinoNode<Document> implements Cloneable, ExtendedHTMLDocument {

	private static final long serialVersionUID = -1250907067692580140L;

	private final NodeAdapterFactory<Node, RhinoDocument> nodeAdapterFactory = new CachingNodeAdapterFactory<Node, RhinoDocument>(new RhinoNodeAdapterFactory());

	private EventDispatcher eventDispatcher;
	private HTMLParser parser;
	private QuerySelector querySelector;
	private Window defaultView;

	protected Map<String, Function> functionsByName() throws NoSuchMethodException {
		final Map<String, Function> map = super.functionsByName();
		map.put("createDocumentFragment", newMethodFunction("createDocumentFragment"));
		map.put("createElement", newMethodFunction("createElement", String.class));
		map.put("addEventListener", newMethodFunction("addEventListener", String.class, EventListener.class, boolean.class));
		map.put("removeEventListener", newMethodFunction("removeEventListener", String.class, EventListener.class, boolean.class));
		map.put("getElementById", newMethodFunction("getElementById", String.class));
		return map;
	}

	public Object get(String name, Scriptable start) {
		return super.get(name, start);
	}

	public RhinoDocument getOwnerDocument() {
		return this;
	}

	@Required
	public QuerySelector getQuerySelector() {
		return querySelector;
	}

	@Required
	public EventDispatcher getEventDispatcher() {
		return eventDispatcher;
	}
	
	@Required
	public NodeAdapterFactory<Node, RhinoDocument> getNodeAdapterFactory() {
		return nodeAdapterFactory;
	}

	@Required
	public HTMLParser getParser() {
		return parser;
	}

	protected void setEventDispatcher(EventDispatcher eventDispatcher) {
		this.eventDispatcher = eventDispatcher;
	}

	public Window getDefaultView() {
		return defaultView;
	}

	protected void setDefaultView(Window defaultView) {
		this.defaultView = defaultView;
	}

	public DocumentType getDoctype() {
		return (DocumentType) adapt(node.getDoctype());
	}

	public Element getDocumentElement() {
		return (Element) adapt(node.getDocumentElement());
	}

	public DOMImplementation getImplementation() {
		throw new UnsupportedOperationException();
	}

	public Element createElement(String tagName) throws DOMException {
		return (Element) adapt(node.createElement(tagName));
	}

	public DocumentFragment createDocumentFragment() {
		return (DocumentFragment) adapt(node.createDocumentFragment());
	}

	public Text createTextNode(String data) {
		throw new UnsupportedOperationException();
	}

	public Comment createComment(String data) {
		throw new UnsupportedOperationException();
	}

	public CDATASection createCDATASection(String data) throws DOMException {
		throw new UnsupportedOperationException();
	}

	public ProcessingInstruction createProcessingInstruction(String target, String data) throws DOMException {
		throw new UnsupportedOperationException();
	}

	public Attr createAttribute(String name) throws DOMException {
		throw new UnsupportedOperationException();
	}

	public EntityReference createEntityReference(String name) throws DOMException {
		throw new UnsupportedOperationException();
	}

	public NodeList getElementsByTagName(String tagname) {
		throw new UnsupportedOperationException();
	}

	public Node importNode(Node importedNode, boolean deep) throws DOMException {
		return adapt(node.importNode(importedNode, deep));
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

	public Element getElementById(final String id) {
		return querySelector.querySelector(this, String.format("#%s", id));
	}

	public String getInputEncoding() {
		throw new UnsupportedOperationException();
	}

	public String getXmlEncoding() {
		throw new UnsupportedOperationException();
	}

	public boolean getXmlStandalone() {
		throw new UnsupportedOperationException();
	}

	public void setXmlStandalone(boolean xmlStandalone) throws DOMException {
		throw new UnsupportedOperationException();
	}

	public String getXmlVersion() {
		throw new UnsupportedOperationException();
	}

	public void setXmlVersion(String xmlVersion) throws DOMException {
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

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		
		private RhinoDocument document;

		public RhinoDocument build() {
			assertRequiredProperties(document);
			final RhinoDocument document = this.document;
			this.document = null;
			return document;
		}

		private void init() {
			if (this.document == null) {
				this.document = new RhinoDocument();
			}
		}
		
		public Builder document(final Document document) {
			init();
			this.document.node = document;
			return this;
		}

		public Builder eventDispatcher(final EventDispatcher eventDispatcher) {
			init();
			document.eventDispatcher = eventDispatcher;
			return this;
		}

		public Builder parser(final HTMLParser parser) {
			init();
			document.parser = parser;
			return this;
		}

		public Builder querySelector(QuerySelector querySelector) {
			init();
			document.querySelector = querySelector;
			return this;
		}
	}

	public void addEventListener(String type, EventListener listener, boolean useCapture) {
		eventDispatcher.addEventListener(this, type, listener, useCapture);
	}

	public void removeEventListener(String type, EventListener listener, boolean useCapture) {
		eventDispatcher.removeEventListener(this, type, listener, useCapture);
	}

	public boolean dispatchEvent(Event event) throws EventException {
		return eventDispatcher.dispatchEvent(event);
	}

	public Element querySelector(String selectors) {
		return querySelector.querySelector(this, selectors);
	}

	public NodeList querySelectorAll(String selectors) {
		return querySelector.querySelectorAll(this, selectors);
	}

	public NodeList getElementsByName(final String name) {
		return querySelectorAll(name);
	}

	public ExtendedHTMLElement getHead() {
		return (ExtendedHTMLElement) querySelector("html > head");
	}
	
	public ExtendedHTMLElement getBody() {
		return (ExtendedHTMLElement) querySelector("html > body");
	}

	public String getTitle() {
		final Element element = querySelector("html > head > title");
		if (element instanceof HTMLTitleElement) {
			return ((HTMLTitleElement)element).getText();
		}
		return null;
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

	public void setBody(HTMLElement body) {
		throw new UnsupportedOperationException();
	}

	public HTMLCollection getImages() {
		return NodeListUtils.toHTMLCollection(querySelectorAll("img"));
	}

	public HTMLCollection getApplets() {
		return NodeListUtils.toHTMLCollection(querySelectorAll("applet"));
	}

	public HTMLCollection getLinks() {
		return NodeListUtils.toHTMLCollection(querySelectorAll("a[href]"));
	}

	public HTMLCollection getForms() {
		return NodeListUtils.toHTMLCollection(querySelectorAll("form"));
	}

	public HTMLCollection getAnchors() {
		return NodeListUtils.toHTMLCollection(querySelectorAll("a[name]"));
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

	public String getClassName() {
		throw new UnsupportedOperationException();
	}
}
