(ns overtone.sql
  "Documentation writer that outputs sql statements
   compatible with the clojuredocs.org project."
  (:import java.net.URLEncoder)
  (:require [clojure.java.jdbc :as jdbc]
            [clojure.java.io :as io]
            [clojure.string :as str]))

(defn write-docs
  "Take raw documentation info and turn it into formatted SQL."
  [project]
  (doseq [namespace (:namespaces project)]
    (println (:name namespace))
    (doseq [function (:function (:publics namespace))]
      (clojure.pprint/pprint {:name (:name function)
       :filepath (:path function)
       :line-number (:line function)
       :argslist (:argslist function)
       :date-added (java.util.Date.)
       :docstring (:doc function)
       :sourcestring (str "")
       :version (:version project)
       :url-friendly-name (str (URLEncoder/encode (str (:name function))))
       :namespace-id (str "")
       }))
    nil))

