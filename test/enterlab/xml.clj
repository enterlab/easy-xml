(ns test.enterlab.xml
	(:require [enterlab.xml :as xml]))

(def street-data {:tag :veje, :attrs {:xmlns "http://itst.dk/schemas/danmarkservice"}, :content [{:tag :vej, :attrs {:ref "http://oiorest.dk/danmark/kommuner/101/veje/2272"}, :content [{:tag :nr, :attrs nil, :content ["2272"]} {:tag :navn, :attrs nil, :content ["Gothersgade"]} {:tag :kommune, :attrs {:ref "http://oiorest.dk/danmark/kommuner/101"}, :content nil}]} {:tag :vej, :attrs {:ref "http://oiorest.dk/danmark/kommuner/791/veje/2665"}, :content [{:tag :nr, :attrs nil, :content ["2665"]} {:tag :navn, :attrs nil, :content ["Gothersgade"]} {:tag :kommune, :attrs {:ref "http://oiorest.dk/danmark/kommuner/791"}, :content nil}]} {:tag :vej, :attrs {:ref "http://oiorest.dk/danmark/kommuner/615/veje/2822"}, :content [{:tag :nr, :attrs nil, :content ["2822"]} {:tag :navn, :attrs nil, :content ["Gothersgade"]} {:tag :kommune, :attrs {:ref "http://oiorest.dk/danmark/kommuner/615"}, :content nil}]} {:tag :vej, :attrs {:ref "http://oiorest.dk/danmark/kommuner/607/veje/2948"}, :content [{:tag :nr, :attrs nil, :content ["2948"]} {:tag :navn, :attrs nil, :content ["Gothersgade"]} {:tag :kommune, :attrs {:ref "http://oiorest.dk/danmark/kommuner/607"}, :content nil}]} {:tag :vej, :attrs {:ref "http://oiorest.dk/danmark/kommuner/615/veje/5844"}, :content [{:tag :nr, :attrs nil, :content ["5844"]} {:tag :navn, :attrs nil, :content ["Ny Gothersgade"]} {:tag :kommune, :attrs {:ref "http://oiorest.dk/danmark/kommuner/615"}, :content nil}]}]})

(xml/elements street-data [:veje :vej :nr])
(xml/texts street-data [:veje :vej :navn])
(xml/attributes street-data [:veje :vej :kommune])

(xml/elements "http://oiorest.dk/danmark/veje?q=ødamsvej" [:veje])
