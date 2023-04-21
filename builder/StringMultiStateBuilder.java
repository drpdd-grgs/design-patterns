package builder;

import java.util.regex.Pattern;

public class StringMultiStateBuilder {
    private String _toCheck;
    private char[] _toCheckArr;
    private boolean _condition;

    public StringMultiStateBuilder(String toCheck) {
        _toCheck = toCheck;
        _toCheckArr = toCheck.toCharArray();
        init();
    }

    public StringMultiStateBuilder isCapitalized() {
        if (_condition) {
            _condition = !Character.isLetter(_toCheckArr[0]) || Character.isUpperCase(_toCheckArr[0]);
        }
        return this;
    }

    public StringMultiStateBuilder contains(String contains) {
        if (_condition) {
            _condition = _toCheck.contains(contains);
        }
        return this;
    }

    public StringMultiStateBuilder matchesByRegex(String regex) {
        if (_condition) {
            _condition = Pattern.compile(regex).matcher(_toCheck).find();
        }
        return this;
    }

    public StringMultiStateBuilder isUpperCase() {
        if (_condition) {
            for (char c : _toCheckArr) {
                if (Character.isLetter(c) && !Character.isUpperCase(c)) {
                    _condition = false;
                    break;
                }
            }
        }
        return this;
    }

    public boolean check() {
        return _condition;
    }

    private void init() {
        _condition = _toCheck != null;
    }
}
