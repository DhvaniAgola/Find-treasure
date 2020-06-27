(ns superstring.core
  (:require [clojure.string :as str]))
(def filename "map.txt")
(def s1 (slurp filename))
(def strng (seq (str/replace s1 #"\r\n" "")))
(def input (vec strng))
(def totalcnt (count input))
(def cnt 0)
(def stop_flag 0)
(def go_ahead 1)
(def line_size 0)
(with-open [rdr (clojure.java.io/reader filename)]
  (doseq [line (line-seq rdr)]
  (if (= stop_flag 1)
  (do
    (if (not= line_size (count line))
    (def go_ahead 0))))
    (def line_size (count line))
    (def stop_flag 1)
  (def cnt (+ cnt 1))))

(if (= go_ahead 1)
(do
(def cols (/ totalcnt cnt))
(def rows cnt))
(println "Input is incorrect"))
(def i 0)

(defn printOutput [input]
  (def a cols)
  (dotimes [n rows]
    (println (apply str (remove #((set "][\n") %) (subvec input (- a cols) a))))
    (def a (+ a cols))))

(if (= go_ahead 1)
(do
  (println "This is my challenge : \n")
  (printOutput input)
  (println "\n\n")
(def m 0)
(def input (assoc input i \+))
(while (= m 0)
(do
(def p 0)
(def q 0)
(if (and (> (+ (- i cols) 1) 0) (= p 0) (= m 0)) ;up
(do
  (if (= (input (- i cols)) \@)
  (do
    (println "Woo hoo, I found the treasure :-)\n")
    (printOutput input)
    (def m 1)))
(if (= (input (- i cols)) \-)
(do
  (def input (assoc input (- i cols) \+))
  (def p (+ p 1))
  (def i (- i cols))))))

(if (and (not= (rem (+ i 1) cols) 0) (= p 0) (= m 0)) ;right
(do
  (if (= (input (+ i 1)) \@)
  (do
    (println "Woo hoo, I found the treasure :-)\n")
    (printOutput input)
    (def m 1)))
  (if (= (input (+ i 1)) \-)
    (do
      (def input (assoc input (+ i 1) \+))
      (def p (+ p 1))
      (def i (+ i 1))))))

(if (and (< (+ i cols) (* cols rows)) (= p 0) (= m 0)) ;down
(do
  (if (= (input (+ i cols)) \@)
  (do
    (println "Woo hoo, I found the treasure :-)\n")
    (printOutput input)
    (def m 1)))
  (if (= (input (+ i cols)) \-)
    (do
      (def input (assoc input (+ i cols) \+))
      (def p (+ p 1))
      (def i (+ i cols))))))

(if (and (not= (rem i cols) 0) (= p 0) (= m 0)) ;left
(do
  (if (= (input (- i 1)) \@)
  (do
    (println "Woo hoo, I found the treasure :-)\n")
    (printOutput input)
    (def m 1)))
  (if (= (input (- i 1)) \-)
  (do
    (def input (assoc input (- i 1) \+))
    (def p (+ p 1))
    (def i (- i 1))
    ))))

(if (= p 0)
  (do
    (def input (assoc input i \!))
    (if (= i 0)
    (do
      (println "Uh oh, I could not find the treasure :-(\n")
      (printOutput input)
      (def m 1)))
    (if (and (not= (rem i cols) 0) (= (input (- i 1)) \+) (= q 0)) ;left
    (do
      (def i (- i 1))
      (def q (+ q 1))))
    (if (and (< (+ i cols) (* cols rows)) (= (input (+ i cols)) \+) (= q 0)) ;down
    (do
      (def i (+ i cols))
      (def q (+ q 1))))
    (if (and (not= (rem (+ i 1) cols) 0) (= (input (+ i 1)) \+) (= q 0)) ;right
    (do
      (def i (+ i 1))
      (def q (+ q 1))))
    (if (and (> (+ (- i cols) 1) 0) (= (input (- i cols)) \+) (= q 0)) ;up
    (do
      (def i (- i cols))
      (def q (+ q 1))))))))))
