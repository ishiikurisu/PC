(defn parse-int [s]
	(Integer. (re-find #"\d+" s)))
(defn read-int []
	(parse-int (read-line)))

(defn setup []

)

(defn draw []
)

(defn main[]
	(for [x range((read-int))]
		(setup)
		(draw)
	)
)
(main)
