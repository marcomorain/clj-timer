(ns clj-timer.core-test
  (:require [clojure.test :refer :all]
            [clj-timer.core :refer :all]))

(defn popper [values]
  (let [stack (atom values)]
    (fn []
      (let [[head & tail] @stack]
        (swap! stack (constantly tail))
        head))))

(deftest timer-can-pause-and-resume
  (with-redefs [clock (popper [1 2 3 4 5 6 7])]
    (let [t (timer) ; started at 1
          paused (pause t) ; paused at 2
          started (paused) ; started at 3
          elapsed (started)] ; read at 4
      (is (= 2 elapsed)))))
