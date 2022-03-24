var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":55,"id":924,"methods":[{"el":23,"sc":2,"sl":17},{"el":42,"sc":2,"sl":30},{"el":53,"sc":2,"sl":44}],"name":"TankerRateTest","sl":13}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_1":{"methods":[{"sl":44}],"name":"testGetLitres","pass":true,"statements":[{"sl":46},{"sl":47},{"sl":49},{"sl":51},{"sl":52}]},"test_31":{"methods":[{"sl":30}],"name":"testGetRate","pass":true,"statements":[{"sl":32},{"sl":33},{"sl":35},{"sl":38},{"sl":39},{"sl":40},{"sl":41}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [31], [], [31], [31], [], [31], [], [], [31], [31], [31], [31], [], [], [1], [], [1], [1], [], [1], [], [1], [1], [], [], []]
