
#define _CRT_SECURE_NO_WARNINGS
#include "header.h" // header에 <stdio.h> 이미 포함되어 있음

/*
void parse_pe_headers(FILE* file) {
    IMAGE_DOS_HEADER dos_header;
    PE_SIGNATURE pe_signature;
    IMAGE_FILE_HEADER file_header;
    IMAGE_OPTIONAL_HEADER optional_header;

    if (file == NULL) {
        fprintf(stderr, "File is not opened\n");
        return;
    }

    // DOS 헤더 읽기
    if (fread(&dos_header, sizeof(IMAGE_DOS_HEADER), 1, file) != 1) {
        fprintf(stderr, "Failed to read DOS header\n");
        return;
    }
    if (dos_header.e_magic != 0x5A4D) { // "MZ" 확인
        fprintf(stderr, "Invalid PE file: DOS magic not found\n");
        return;
    }

    // NT 헤더 위치로 이동
    fseek(file, dos_header.e_lfanew, SEEK_SET);

    // PE 시그니처 읽기
    if (fread(&pe_signature, sizeof(PE_SIGNATURE), 1, file) != 1 || pe_signature.Signature != 0x00004550) {
        fprintf(stderr, "Invalid PE Signature\n");
        return;
    }

    // FILE_HEADER 읽기
    if (fread(&file_header, sizeof(IMAGE_FILE_HEADER), 1, file) != 1) {
        fprintf(stderr, "Failed to read File Header\n");
        return;
    }

    // OPTIONAL_HEADER 읽기
    if (fread(&optional_header, sizeof(IMAGE_OPTIONAL_HEADER), 1, file) != 1) {
        fprintf(stderr, "Failed to read Optional Header\n");
        return;
    }

    // 결과 출력
    printf("Machine: %x\n", file_header.Machine);
    printf("Number of Sections: %d\n", file_header.NumberOfSections);
    printf("Size of Optional Header: %d\n", file_header.SizeOfOptionalHeader);
}
*/

/*
void parse_pe_headers(FILE* file) {
    if (file == NULL) {
        fprintf(stderr, "File is not opened\n");
        return;
    }

    IMAGE_DOS_HEADER dosHeader;
    if (fread(&dosHeader, sizeof(IMAGE_DOS_HEADER), 1, file) != 1) {
        fprintf(stderr, "Failed to read DOS header\n");
        return;
    }

    if (dosHeader.e_magic != 0x5A4D) { // "MZ" 매직 넘버 확인
        fprintf(stderr, "Invalid PE file: DOS magic not found\n");
        return;
    }

    // NT 헤더의 위치로 이동
    fseek(file, dosHeader.e_lfanew, SEEK_SET);
    IMAGE_NT_HEADERS ntHeaders;
    if (fread(&ntHeaders, sizeof(IMAGE_NT_HEADERS), 1, file) != 1) {
        fprintf(stderr, "Failed to read NT headers\n");
        return;
    }

    // 세부 정보 출력
    printf("PE Signature: %X\n", ntHeaders.Signature.Signature);
    printf("Machine: %X\n", ntHeaders.FileHeader.Machine);
    printf("Number of Sections: %d\n", ntHeaders.FileHeader.NumberOfSections);
    printf("Size of Optional Header: %d\n", ntHeaders.FileHeader.SizeOfOptionalHeader);
    printf("Characteristics: %X\n", ntHeaders.FileHeader.Characteristics);

    // Optional Header 정보 출력
    printf("ImageBase: %X\n", ntHeaders.OptionalHeader.ImageBase);
    printf("Entry Point: %X\n", ntHeaders.OptionalHeader.AddressOfEntryPoint);
    printf("Code Size: %d\n", ntHeaders.OptionalHeader.SizeOfCode);
}

*/


void parse_pe_headers(FILE* file) {
    if (file == NULL) {
        fprintf(stderr, "File is not opened\n");
        return;
    }

    

    IMAGE_DOS_HEADER dosHeader;
    if (fread(&dosHeader, sizeof(IMAGE_DOS_HEADER), 1, file) != 1) {
        fprintf(stderr, "Failed to read DOS header\n");
        return;
    }

    if (dosHeader.e_magic != 0x5A4D) { // "MZ" 매직 넘버 확인
        fprintf(stderr, "Invalid PE file: DOS magic not found\n");
        return;
    }

    // 세부 정보 출력
    printf("DOS Header:\n");
    printf("  Magic number: %04X\n", dosHeader.e_magic);
    printf("  Bytes on last page of file: %u\n", dosHeader.e_cblp);
    printf("  Pages in file: %u\n", dosHeader.e_cp);
    printf("  Relocations: %u\n", dosHeader.e_crlc);
    printf("  Size of header in paragraphs: %u\n", dosHeader.e_cparhdr);
    printf("  Minimum extra paragraphs needed: %u\n", dosHeader.e_minalloc);
    printf("  Maximum extra paragraphs needed: %u\n", dosHeader.e_maxalloc);
    printf("  Initial (relative) SS value: %u\n", dosHeader.e_ss);
    printf("  Initial SP value: %u\n", dosHeader.e_sp);
    printf("  Checksum: %u\n", dosHeader.e_csum);
    printf("  Initial IP value: %u\n", dosHeader.e_ip);
    printf("  Initial (relative) CS value: %u\n", dosHeader.e_cs);
    printf("  File address of relocation table: %u\n", dosHeader.e_lfarlc);
    printf("  Overlay number: %u\n", dosHeader.e_ovno);
    printf("  OEM ID: %u\n", dosHeader.e_oemid);
    printf("  OEM Information: %u\n", dosHeader.e_emoinfo);

    // NT 헤더의 위치로 이동
    fseek(file, dosHeader.e_lfanew, SEEK_SET);
    IMAGE_NT_HEADERS ntHeaders;
    if (fread(&ntHeaders, sizeof(IMAGE_NT_HEADERS), 1, file) != 1) {
        fprintf(stderr, "Failed to read NT headers\n");
        return;
    }

    // NT 헤더 정보 출력
    printf("\nNT Headers:\n");
    printf("  Signature: %08X\n", ntHeaders.Signature.Signature);

    // 파일 헤더 정보 출력
    printf("\nFile Header:\n");
    printf("  Machine: %04X\n", ntHeaders.FileHeader.Machine);
    printf("  Number of Sections: %d\n", ntHeaders.FileHeader.NumberOfSections);
    printf("  Time Date Stamp: %u\n", ntHeaders.FileHeader.TimeDateStamp);
    printf("  Pointer to Symbol Table: %u\n", ntHeaders.FileHeader.PointerToSymbolTable);
    printf("  Number of Symbols: %u\n", ntHeaders.FileHeader.NumberOfSymbols);
    printf("  Size of Optional Header: %u\n", ntHeaders.FileHeader.SizeOfOptionalHeader);
    printf("  Characteristics: %04X\n", ntHeaders.FileHeader.Characteristics);

    // 옵셔널 헤더 정보 출력
    printf("\nOptional Header:\n");
    printf("  Magic: %04X\n", ntHeaders.OptionalHeader.Magic);
    printf("  Major Linker Version: %d\n", ntHeaders.OptionalHeader.MajorLinkerVersion);
    printf("  Minor Linker Version: %d\n", ntHeaders.OptionalHeader.MinorLinkerVersion);
    printf("  Size of Code: %u\n", ntHeaders.OptionalHeader.SizeOfCode);
    printf("  Size of Initialized Data: %u\n", ntHeaders.OptionalHeader.SizeOfInitializedData);
    printf("  Size of Uninitialized Data: %u\n", ntHeaders.OptionalHeader.SizeOfUninitializedData);
    printf("  Address of Entry Point: %08X\n", ntHeaders.OptionalHeader.AddressOfEntryPoint);
    printf("  Base of Code: %08X\n", ntHeaders.OptionalHeader.BaseOfCode);
    printf("  Image Base: %08X\n", ntHeaders.OptionalHeader.ImageBase);
    printf("  Section Alignment: %u\n", ntHeaders.OptionalHeader.SectionAlignment);
    printf("  File Alignment: %u\n", ntHeaders.OptionalHeader.FileAlignment);
    printf("  Major Operating System Version: %d\n", ntHeaders.OptionalHeader.MajorOperatingSystemVersion);
    printf("  Minor Operating System Version: %d\n", ntHeaders.OptionalHeader.MinorOperatingSystemVersion);
    printf("  Major Image Version: %d\n", ntHeaders.OptionalHeader.MajorImageVersion);
    printf("  Minor Image Version: %d\n", ntHeaders.OptionalHeader.MinorImageVersion);
    printf("  Major Subsystem Version: %d\n", ntHeaders.OptionalHeader.MajorSubsystemVersion);
    printf("  Minor Subsystem Version: %d\n", ntHeaders.OptionalHeader.MinorSubsystemVersion);
    printf("  Size of Image: %u\n", ntHeaders.OptionalHeader.SizeOfImage);
    printf("  Size of Header: %u\n", ntHeaders.OptionalHeader.SizeOfHeader);
    printf("  CheckSum: %u\n", ntHeaders.OptionalHeader.CheckSum);
    printf("  Subsystem: %04X\n", ntHeaders.OptionalHeader.Subsystem);
    printf("  DLL Characteristics: %04X\n", ntHeaders.OptionalHeader.DllCharacteristics);
    printf("  Size of Stack Reserve: %u\n", ntHeaders.OptionalHeader.SizeOfStackReserve);
    printf("  Size of Stack Commit: %u\n", ntHeaders.OptionalHeader.SizeOfStackCommit);
    printf("  Size of Heap Reserve: %u\n", ntHeaders.OptionalHeader.SizeOfHeapReserve);
    printf("  Size of Heap Commit: %u\n", ntHeaders.OptionalHeader.SizeOfHeapCommit);
    printf("  Loader Flags: %u\n", ntHeaders.OptionalHeader.LoaderFlags);
    printf("  Number of RVA and Sizes: %u\n", ntHeaders.OptionalHeader.NumberOfRvaAndSizes);
}


int main() {
    FILE* file;
  

    /* 파일 이름 입력받기
    char file_name[100];
    scanf("%s", &file_name);
    err = fopen_s(&file, file_name, "rb");
    */

    /* Windows에서 Notepad.exe 파일 열기
    errno_t err;
    err = fopen_s(&file, "C:\\Windows\\System32\\notepad.exe", "rb"); // 이진 읽기 모드
    if (err != 0 || file == NULL) {
        fprintf(stderr, "Cannot open file\n");
        return 1;
    }
    */

    // 표준 fopen 방식
    FILE* file = fopen("notepad.exe", "rb");
    if (file == NULL) {
        fprintf(stderr, "Cannot open file\n");
        return 1;
    }

    // PE 헤더 파싱
    parse_pe_headers(file);

    // 파일 닫기
    fclose(file);
    return 0;
}