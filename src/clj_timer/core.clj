(ns clj-timer.core)

(def clock (fn [] (System/nanoTime)))

(defn- base [elapsed]
  (let [start (clock)]
    (fn []
      (+ elapsed (- (clock) start)))))

(defn timer
  "Start a timer and return a function that returns the current elapsed time"
  []
  (base 0))

(defn pause
  "Pause a running timer and return a function that resumes the timer"
  [timer]
  (let [elapsed (timer)]
    (fn []
      (base elapsed))))
