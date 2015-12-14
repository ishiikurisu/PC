(require '[clojure.string :as str])
(defn parse-int [s]
   (Integer. (re-find  #"\d+" s)))
(defn read-int []
    (parse-int (read-line)))
(println (+ (read-int) (read-int)))
