(ns enterlab.xml
  (:require [clojure.xml :as xml]))

(defn elements [_input path]
  (let [input (if (map? _input) [_input] _input)
        is-path-keyword? (keyword? path)]
     (cond
        (and (vector? input)
             (or is-path-keyword?
                 (and (seq path)
                      (keyword? (first path)))))
           (let [path-entry (if is-path-keyword?
                              path
                              (first path))
                 rest-path (if is-path-keyword?
                             nil
                             (rest path))
                 matching-map-entries (filter #(and (map? %) (= path-entry (:tag %))) input)
                 content-from-maps (if (seq rest-path) (map :content matching-map-entries) matching-map-entries)
                 flattened-content (flatten content-from-maps)]
             (recur (into [] flattened-content) rest-path)
           )
        (vector? input) input
        :else {:error (format "Unknown input to elements:\n*** input:\n %s\n***path: %s" input path)})))

(defn texts [input path]
   (let [elements (elements input path)
         content (map :content elements)
         text-elems (seq (filter string? (flatten content)))]
     (when text-elems text-elems)))

(defn attributes [input path]
   (let [elements (elements input path)
         attrs (map :attrs elements)]
     (when attrs attrs)))
