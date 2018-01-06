(require '[clojure.string :as str])
(defn parse-int [s]
   (Integer. (re-find  #"\d+" s)))
(defn read-int []
    (parse-int (read-line)))

(defn spoj-test [inlet]
    (loop [n inlet]
        (when (not (= n 42))
            (println n)
            (recur (read-int)))))
(spoj-test (read-int))
