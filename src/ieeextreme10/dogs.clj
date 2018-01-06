(def infinity Double/POSITIVE_INFINITY)

(defn read-dogs [number-dogs]
    (loop [i 0
           dogs (vector)]
        (if (= i number-dogs)
            dogs
            (recur (inc i)
                   (conj dogs (read-string (read-line)))))))

(defn create-limits [number-walkers]
    (loop [limits (vector)
           i 1]
        (if (= i number-walkers)
            limits
            (recur (conj limits i)
                   (inc 1)))))

(defn cant-walk [limits]
    "can the first item be incremented?"
    (= (count limits) 0)
)

(defn walk [limits number-dogs number-walkers]
    (if (= 1 (count limits))
        (if (= (first limits) (dec number-dogs))
            (vector)
            (assoc limits 0 (inc (first limits))))
        (loop [i 0
               nl limits]
            (if (= i (count nl))
                (if (= (last nl) (dec number-dogs))
                    (vector)
                    (assoc nl (dec (count limits)) (inc (nth nl i))))
                (recur (inc i)
                       (assoc nl i (inc (nth nl i))))))))

(defn calculate [dogs limits]
    (loop [total 0
           i 1]
        (if (= i (count limits))
            total
            (recur (+ total (- (nth dogs (limits i))
                               (nth dogs (limits (dec i)))))
                   (inc i)))))

(defn go-horse [ ]
    (let [first-line (clojure.string/split (read-line) #" ")
          number-dogs (read-string (nth first-line 0))
          number-walkers (read-string (nth first-line 1))
          dogs (sort < (read-dogs number-dogs))]
        (loop [limits (create-limits number-walkers)
               outlet infinity]
            (if (cant-walk limits)
                outlet
                (do (println limits)
                    (recur (walk limits number-dogs number-walkers)
                           (min outlet (calculate dogs limits))))))))

(defn main [T]
    (if (= T 0)
        nil
            (do (println (go-horse))
            (main (- T 1)))))

(main (read-string (read-line)))
