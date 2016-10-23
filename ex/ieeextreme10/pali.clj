(defn npali [n word stuff changes]
    (if (= n 0)
        stuff
        ))

(defn go-horse []
    (let [raw (clojure.string/split (read-line) #" ")
          n (read-string (nth raw 0))
          word (nth raw 1)]
        (npali n word (set) (set))))

(defn main [T]
    (loop [i 0]
        (if (= i T)
            nil
            (do (println (go-horse))
                (recur (inc i))))))

(main (read-string (read-line)))
