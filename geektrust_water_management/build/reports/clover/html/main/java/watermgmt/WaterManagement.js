var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":13,"id":127,"methods":[{"el":6,"sc":2,"sl":5},{"el":12,"sc":2,"sl":8}],"name":"WaterManagement","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_7":{"methods":[{"sl":5},{"sl":8}],"name":"testMain","pass":true,"statements":[{"sl":9},{"sl":10}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [7], [], [], [7], [7], [7], [], [], []]
