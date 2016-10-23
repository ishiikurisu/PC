(defn flower [n]
    (ceil (+ 1 (* 2 (- n (pow 2 (floor (log n 2))))))))

(defn main [T]
    (loop [i 0]
        (if (= i T)
            nil
            (do (println (flower (read-string (read-line))))
                (recur (inc i))))))

(main (read-string (read-line)))
