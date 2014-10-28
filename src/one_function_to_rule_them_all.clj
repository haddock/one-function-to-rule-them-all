(ns one-function-to-rule-them-all)

(defn concat-elements [a-seq]
  (reduce concat '() a-seq))

(defn str-cat [a-seq]
  (if (empty? a-seq)
    ""
    (reduce #(str %1 " " %2) a-seq)))

(defn my-interpose [x a-seq]
  (cond (empty? a-seq) '()
        (empty? (next a-seq)) (seq a-seq)
        :else (seq (reduce #(conj %1 x %2) (vector (first a-seq)) (rest a-seq)))))

(defn my-count [a-seq]
  (let [counter (fn [i elem]
                  (inc i))]
    (reduce counter 0 a-seq)))

(defn my-reverse [a-seq]
  (reduce #(cons %2 %1) '() a-seq))

(defn min-max-element [a-seq]
  (if (empty? a-seq)
    a-seq
    (let [min-max-reducer (fn [min-max elem]
                            (vector
                             (min (first min-max) elem)
                             (max (last min-max) elem)))]
      (reduce min-max-reducer [(first a-seq) (first a-seq)] (rest a-seq)))))

(defn insert [sorted-seq n]
  (loop [result '() tmp-seq sorted-seq]
    (if (or (empty? tmp-seq) (<= n (first tmp-seq)))
      (concat result (cons n tmp-seq))
      (recur (concat result (list (first tmp-seq))) (rest tmp-seq)))))

(defn insertion-sort [a-seq]
  (reduce #(insert %1 %2) [] a-seq))

(defn parity [a-seq]
  (let [toggle (fn [a-set elem]
                 (if (contains? a-set elem)
                   (disj a-set elem)
                   (conj a-set elem)))]
    (reduce toggle #{} a-seq)))

(defn minus [x]
  :-)

(defn count-params [x]
  :-)

(defn my-* [x]
  :-)

(defn pred-and [x]
  (fn [x] :-))

(defn my-map [f a-seq]
  [:-])
