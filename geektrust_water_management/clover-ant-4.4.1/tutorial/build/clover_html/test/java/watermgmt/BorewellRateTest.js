var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":42,"id":610,"methods":[{"el":22,"sc":2,"sl":17},{"el":29,"sc":2,"sl":24},{"el":40,"sc":2,"sl":31}],"name":"BorewellRateTest","sl":13}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_15":{"methods":[{"sl":24}],"name":"testGetRate","pass":true,"statements":[{"sl":26},{"sl":27},{"sl":28}]},"test_36":{"methods":[{"sl":31}],"name":"testGetLitres","pass":true,"statements":[{"sl":33},{"sl":34},{"sl":35},{"sl":36},{"sl":38}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [15], [], [15], [15], [15], [], [], [36], [], [36], [36], [36], [36], [], [36], [], [], [], []]
