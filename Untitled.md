```
ab\{2,3}c:      "abbc" or "abbbc"
a\{5}:          "aaaaa"
ab\{2,}c:       "abbc", "abbbc", "abbbbc", etc.
ab\{-,3}c:      "ac", "abc", "abbc" or "abbbc"
a[bc]\{3}d:     "abbbd", "abbcd", "acbcd", "acccd", etc.
a\(bc\)\{1,2}d: "abcd" or "abcbcd"
a[bc]\{-}[cd]:  "abc" in "abcd"
a[bc]*[cd]:     "abcd" in "abcd"
\(foo\)\@<!bar  查找不以foo开头的bar
```
