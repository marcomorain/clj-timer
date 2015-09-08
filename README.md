# clj-timer

A Clojure library to implement a functional timer.

## Usage

```Clojure
(require '[clj-timer.core :as timer])

(def t (timer/start))

(printf "Elapsed: %s\n" (t))
; Elapsed: 113742813

(printf "Elapsed: %s\n" (t))
; Elapsed: 174790514

```
## License

Copyright © 2015 Marc O'Morain

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
