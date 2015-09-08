(ns clj-timer.core)

(def clock
  "Expose the underlying timer to allow tests to mock it."
  (fn [] (System/nanoTime)))

(defn- timer [elapsed]
  (let [start (clock)]
    (fn []
      (+ elapsed (- (clock) start)))))

(defn start
  "Start a timer and return a function that returns the current elapsed time"
  []
  (timer 0))

(defn pause
  "Pause a running timer and return a function that resumes the timer"
  [t]
  (let [elapsed (t)]
    (fn []
      (timer elapsed))))
