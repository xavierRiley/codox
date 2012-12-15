(ns codox.writer.sql
  "Documentation writer that outputs sql statements
   compatible with the clojuredocs.org project."
  (:use [hiccup core page element])
  (:import java.net.URLEncoder)
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(defn write-docs
  "Take raw documentation info and turn it into formatted SQL."
  [project]
  (doseq [namespace (:namespaces project)]
    (println (:name namespace)))
    nil)
