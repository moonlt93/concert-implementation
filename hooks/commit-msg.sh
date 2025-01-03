#!/bin/bash

# Define valid prefixes
VALID_PREFIXES="^(feat|fix|test|build|design|refactor|docs|chore):"

# Get the commit message file
COMMIT_MSG_FILE="$1"

# Read the commit message
COMMIT_MSG=$(cat "$COMMIT_MSG_FILE")

# Check if the commit message is a merge commit
if echo "$COMMIT_MSG" | grep -q '^Merge'; then
  exit 0
fi

# Check if the commit message starts with a valid prefix
if ! echo "$COMMIT_MSG" | grep -qiE "$VALID_PREFIXES"; then
  echo "Error: 커밋 컨벤션을 맞춰주세요!!"
  echo " feat: ~~~ 기능 추가"
  echo "  fix: ~~~ 오류 수정"
  echo "  test: ~~~ test 추가/수정"
  echo "  build: ~~~ 빌드 관련 수정"
  echo "  design: ~~~ CSS 등 사용자 UI 디자인 변경"
  echo "  refactor: ~~ 기능 리팩토링"
  echo "  docs: ~~ 문서관련 변경"
  echo "  chore: 나머지(주석 추가/변경, 코드 스타일, 포맷팅 관련 수정 등)"
  exit 1
fi

exit 0