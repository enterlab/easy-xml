easy-xml
========

Small Clojure parsing library wrapping clojure.xml.

Makes it a breeze to extract elements, texts and attributes from XML sources (URLs or pre-parsed with clojure.xml/parse).

Examples
========

In the following we'll use this Danish public web service, that returns addresses based on a search query.

In this case we search for "Gothersgade".
 
The URL for the service is:

