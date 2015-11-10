(defn comp [func]
	#(if (func %1 %2) %1 %2))
(def max (comp >))
(def min (comp <))

(defn main [g b]
	(cond
		(or (= g 0) (= b 0)) (max g b)
		(= (min g b) 1)
			(let [m (max g b)]
				(if (> m 2)
					(- m 2)
					1))
		:else (/ (max g b) (min g b))))
(println (main 10 10))
(println (main 0 1000))
(println (main 1 5))
